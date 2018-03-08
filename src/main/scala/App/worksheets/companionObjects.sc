trait Vehicle {
  val age: Int
}

case class Car private(make: String, model: String, override val age: Int) extends Vehicle {
  def this() = this(make, model, age)
}

object Car {
  def fromMakeAndModel(make: String, model: String): Unit = {
    new Car(make, model, 0)
  }
}

Car.fromMakeAndModel("Seat", "Leon")
Car.fromMakeAndModel("VW", "Golf")
Car.fromMakeAndModel("Ford", "Fiesta")