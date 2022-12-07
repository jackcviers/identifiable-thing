package example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import example.IdentifiableThing.ops._

class ThingExtensionSpec extends AnyFlatSpec with Matchers{

  "getsomething" should "work for identifiable things even when identifiable thing is sealed" in {
    val otherThing = OtherThing(1)
    IdentifiableThing[OtherThing].getSomething(otherThing) shouldEqual Something(1)
  }
  "getsomething op" should "work for identifiable things even when identifiable thing is sealed" in {
    val otherThing = OtherThing(1)
    otherThing.getSomething shouldEqual Something(1)
  }
}
