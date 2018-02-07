
class Product(val name: String, val category: String, val price: Int) {
  override def toString(): String = {
    s"$name - $category ($price)"
  }
}

val bread = new Product("Bread", "Food", 80)
val milk = new Product("Milk", "Food", 60)
val washingUpLiquid = new Product("Washing up liquid", "Household", 100)
val bleach = new Product("Bleach", "Household", 70)

val basket = List(bread, milk, milk, washingUpLiquid, bleach)

// Work out total of basket
basket.foldRight(0)((prod, acc) => prod.price + acc) // Normal
basket.foldRight(0)(_.price + _) // With syntactic sugar

// How much is spent on food?
basket.filter(p => p.category == "Food")
  .foldRight(0)(_.price + _)

// What if there is a 10% off sale?
basket.map(_.price * 0.9)
  .foldRight(0d)(_ + _)

// What is the total if you have a voucher for 50% washing up liquid

// Long winded
val washingUpTotal = basket.filter(p => p.name == "Washing up liquid")
  .map(_.price * 0.5)
  .foldRight(0d)(_ + _)
val othersTotal = basket.filter(p => p.name != "Washing up liquid")
  .map(_.price)
  .foldRight(0d)(_ + _)

washingUpTotal + othersTotal

// Simple
basket.map(p => if (p.name == "Washing up liquid")
                    p.price * 0.5
                else
                    p.price).foldRight(0d)(_ + _)
