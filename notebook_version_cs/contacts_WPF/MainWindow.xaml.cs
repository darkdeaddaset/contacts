using System;
using System.Windows;
using System.Data.SqlClient;
using System.Data;

namespace WpfApp1
{
    /// <summary>
    /// Логика взаимодействия для MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        string connect = "Server=(localdb)\\mssqllocaldb;Database=contacts;Trusted_Connection=True;";
        SqlConnection connection;
        SqlDataAdapter adapter;
        DataTable dt;

        public MainWindow()
        {
            InitializeComponent();
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            string sql = "SELECT * FROM person";
            dt = new DataTable();
            try
            {
                connection = new SqlConnection(connect);
                SqlCommand cmd = new SqlCommand(sql, connection);
                adapter = new SqlDataAdapter(cmd);

                adapter.InsertCommand = new SqlCommand("sp_InsertContacts", connection);
                adapter.InsertCommand.CommandType = CommandType.StoredProcedure;
                adapter.InsertCommand.Parameters.Add(new SqlParameter("@Name", SqlDbType.NVarChar, 30, "Name"));
                adapter.InsertCommand.Parameters.Add(new SqlParameter("@Email", SqlDbType.NVarChar, 50, "Email"));
                adapter.InsertCommand.Parameters.Add(new SqlParameter("@Number", SqlDbType.NVarChar, 12, "Number"));
                SqlParameter parameter = adapter.InsertCommand.Parameters.Add("@Id", SqlDbType.Int, 0, "Id");
                parameter.Direction = ParameterDirection.Output;

                connection.Open();
                adapter.Fill(dt);
                contactsGrid.ItemsSource = dt.DefaultView;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                if (connection != null)
                {
                    connection.Close();
                }
            }
        }

        private void UpdateBtn_Click(object sender, RoutedEventArgs e)
        {
            SqlCommandBuilder cmdBuilder = new SqlCommandBuilder(adapter);
            adapter.Update(dt);
        }

        private void DeletedBtn_Click(object sender, RoutedEventArgs e)
        {
            if (contactsGrid.SelectedItems!=null)
            {
                for (int i = 0; i < contactsGrid.SelectedItems.Count; i++)
                {
                    DataRowView dataRowView = contactsGrid.SelectedItems[i] as DataRowView;
                    if (dataRowView != null)
                    {
                        DataRow row = (DataRow)dataRowView.Row;
                        row.Delete();
                    }
                }
            }
            SqlCommandBuilder cmdBuilder = new SqlCommandBuilder(adapter);
            adapter.Update(dt);
        }
    }
}
