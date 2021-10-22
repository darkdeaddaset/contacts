using Microsoft.EntityFrameworkCore;

namespace Notebook
{
    public class ApplicationContext:DbContext
    {
        public DbSet<Person> persons { get; set; }
        public ApplicationContext()
        {
            //Database.EnsureDeleted();
            Database.EnsureCreated();
        }
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseNpgsql("Host=localhost;Port=5433;Database=notebookdb;Username=postgres;Password=savindmitriy1999");
        }
    }
}
