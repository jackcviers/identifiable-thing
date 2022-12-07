package example

sealed trait IdentifiableThing[A] {
  def getSomething(thing: A): Something
}

object IdentifiableThing {
  def apply[A: IdentifiableThing]: IdentifiableThing[A] = implicitly[IdentifiableThing[A]]
  implicit val otherThingToSomething: IdentifiableThing[OtherThing] = new IdentifiableThing[OtherThing]{
    def getSomething(thing: OtherThing): Something = thing.something
  }

  object ops{
    implicit class IdentifiableThingOps[A](val underlying: A) extends AnyVal {
      def getSomething(implicit it: IdentifiableThing[A]): Something = it.getSomething(underlying)
    }
  }
}
