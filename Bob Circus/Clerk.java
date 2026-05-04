public class Clerk extends Person {
	
	private String job;
	private int yearsWorked;
	private String imagePath;
	
	public Clerk() {
		super("",0,0,"","");
		this.job = "";
		this.yearsWorked =0;
		this.imagePath = "";
	}

    public Clerk(String name, int age, int yearsWorked, String job, String imagePath) {
    	super(name, age, yearsWorked, job, imagePath);
        this.job = job;
        this.yearsWorked = yearsWorked;
        this.imagePath = imagePath;
    }
    
    public String getJob() {
    	return job;
    }
    
    public int getYearsWorked() {
    	return yearsWorked;
    }
    
  public String getImagePath() {
	  return imagePath;
  }
    
    

    @Override
    public String toString() {
         return "Clerk - " + super.toString();
    }
}
