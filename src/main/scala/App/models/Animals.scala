package App.models

object Animals extends App {
  val d1 = new Dog("Reef")
  val c1 = new Cat("Kylo")

  println(s"${d1.name} ${d1.talk}")
  println(s"${c1.name} ${c1.talk}")

  val pets : List[Pet with Talking] = List(d1,c1)

  pets.foreach(p => println(p.talk))
}

trait Pet {
  val name: String
}
trait Talking {
  def talk: String
}
trait Woof extends Talking {
  override def talk: String = "woof"
}
trait Meow extends Talking {
  override def talk : String = "meow"
}
final class Dog(override val name: String) extends Pet with Talking with Woof
final class Cat (override val name : String) extends Pet with Talking with Meow