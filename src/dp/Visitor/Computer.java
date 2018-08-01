package dp.Visitor;

public class Computer implements ComputerPart{
	 ComputerPart[] parts;
	 
	   public Computer(){
	      parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};      
	   } 
	 
	 
	   @Override
	   public void accept(ComputerPartVisitor computerPartVisitor) {
		   System.out.println("info : " + parts.length);
	      for (int i = 0; i < parts.length; i++) {
	         parts[i].accept(computerPartVisitor);
	      }
	      // 访问 Computer
	      computerPartVisitor.visit(this);
	   }
}
