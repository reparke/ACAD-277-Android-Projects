
public class Program {

	public static void main(String[] args) {
		
		
		Animal myAnimal = new Animal("Cow", "Moo");
		myAnimal.makeSound();
		System.out.println();
		System.out.println();
		
		Animal animals[] = new Animal[7];
		animals[0] = myAnimal;
		animals[1] = new Cat();
		animals[2] = new Cat("Grumpy Cat", "I'm grumpy");
		animals[3] = new Bat();
		animals[4] = new Bat("Dracula", "Blah");
		animals[5] = new Canary();
		animals[6] = new Canary("Tweety", "I saw a puddy cat");
		
		for (int i = 0; i < animals.length; i++) {
			System.out.print(animals[i].getName() + " says ");
			animals[i].makeSound();
			System.out.println();
		}
		System.out.println();
		
		
	}

}
