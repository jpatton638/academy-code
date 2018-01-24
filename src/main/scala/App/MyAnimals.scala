package App

/**
  * Created by john on 24/01/18.
  */
object MyAnimals extends App {
  val jess : Animal = new Cat()
  val lassie : Animal = new Dog()
  val ghost : Dog = new Wolf()
  val bT : BorderTerrier = new BorderTerrier()
  val snowball : Cat = new Persian()
  val meowth : Cat = new Meowth(5, true)
  val otherMeowth : Cat = new Meowth(12, false)


  println(jess.speak())
  println(lassie.speak())
  println(ghost.speak())
  println(bT.speak())
  println(bT.hunt())
  println(snowball.speak())
  println(meowth.speak())
  println(otherMeowth.speak())
}

abstract class Animal {
  def speak(): String
}

class Dog extends Animal {
  override def speak(): String = {
    "Woof!"
  }
}

class Wolf extends Dog {
  override def speak(): String = {
    "Howl!"
  }
}

class BorderTerrier() extends Dog {
  speak()
  def hunt(): String = "I hunt rats"
}

class Cat extends Animal {
  override def speak(): String = {
    "Meow!"
  }
}

class Persian extends Cat {
  speak()
}

class Meowth(coins: Int, teamRocket: Boolean) extends Cat {
  override def speak(): String = {
    val sentence = s"That's right! I have $coins coins,"
    if (teamRocket) {
      s"$sentence I am in team rocket!"
    } else {
      s"$sentence I am not in team rocket!"
    }
  }
}


