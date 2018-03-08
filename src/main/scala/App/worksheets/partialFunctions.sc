val divide = (x: Int) => 42 / x
List(1,2).map(divide)
divide(2)


/**
  * Define a partial function for a range of inputs
  */

val dividePF = new PartialFunction[Int, Int] {
  def apply(x: Int) = 42 / x

  override def isDefinedAt(x: Int): Boolean = x != 0
}

val x = 2
// Use the test in a conditional expression
if (dividePF.isDefinedAt(x)) {
  // Call the apply method
  dividePF(x)
} else {
  println("Can't handle 0")
}

/**
  * Define a partial function shorthand with case statement
  */
val handleZeros : PartialFunction[Int, Int] = {
  case y => y
}

// Another p function
val dividePF2: PartialFunction[Int, Int] = {
  case y if y != 0 => 42 / y
}

/**
  * Using function composition orElse to combine p functions
    together into a composedFunction
  *
  * PartialFunction is a subtype of Function
  */
val divideOrHandle = dividePF2 orElse handleZeros
// Use new composed function or argument for map
List(0,1,2,3,4,5).map(divideOrHandle)

// ".collect" takes a partial function and filters out cases
// the PF can't handle
List(0,1,2,3,4,5).collect(dividePF2)

val isEven: PartialFunction[Int, String] = {
  case x : Int if x % 2 == 0 => s"$x is even"
}

val numbers = 1 to 5
val evenNumbers = numbers collect isEven

val double = (n: Int) => n * 2
val addOne = (n: Int) => n + 1

// andThen is left-evaluative
val doublePlusOneThen = double andThen addOne
// compose is right-evaluative
val doublePlusOneComp = double compose addOne

val nums = (1 to 20).toList
nums.map(doublePlusOneThen)
nums.map(doublePlusOneComp)

def double2(n : Int) = n * 2
def addOne2(n : Int) = n + 1
// Composing standard functions together
def doubleAndPlusOne(n : Int) = {
  double2(addOne2(n))
}
