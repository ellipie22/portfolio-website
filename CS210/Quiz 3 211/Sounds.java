

public class Sounds {
	public static void main(String[] args) {
		Animal Coco = new Cat();
		//Creates animals of each class type (2 dogs, 2 cats and one chicken), then plays the sound for each of the animals.
		Coco.sound();
		Animal Lazy = new Cat();
		Lazy.sound();
		Animal Max = new Dog();
		Max.sound();
		Animal Buddy = new Dog();
		Buddy.sound();
		Animal Fried = new Chicken();
		Fried.sound();
	}
}
