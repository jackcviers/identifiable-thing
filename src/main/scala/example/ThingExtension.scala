package example

object ThingExtension {
  def getSomethingId[A](thing: A)(implicit identifiable: IdentifiableThing[A]): String =
    identifiable.getSomething(thing).toString
}
