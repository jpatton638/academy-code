class Animal()
class Cat(val breed: String) extends Animal
class Dog(val breed: String) extends Animal

val a1 = new Animal
val c1 = new Cat("Bengal")
val d1 = new Dog("German Shepard")

val tuple1: (Animal, Cat, Dog) = (a1, c1, d1)

tuple1._1
tuple1._2
tuple1._3

