def intMap(list: List[Int], f: Int => Int): List[Int] = {

  if (list != Nil) {
    f(list.head) :: intMap(list.tail, f)
  } else {
    Nil
  }
}

intMap(List(1,2,3,4,5), x => x + 2)
intMap(List(10,20,30,40,50), x => x * 5)