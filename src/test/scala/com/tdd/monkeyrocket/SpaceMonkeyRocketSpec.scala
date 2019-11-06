package com.tdd.monkeyrocket

import com.tdd.monkeyrocket.Setup.{DefaultSetup, NoSetup}
import org.scalatest.{Matchers, PrivateMethodTester, WordSpec}
import java.lang.{ IllegalArgumentException => IAE }
import com.tdd.monkeyrocket.{ MonkeyTouchingException => MTE }

class SpaceMonkeyRocketSpec extends WordSpec with Matchers with PrivateMethodTester {

  val SUCCESS = "COHETE LANZADO"

  private def goodMonkeys: Int => Boolean = _ => true
  private def badMonkeys: Int => Boolean = _ => false

  "SpaceMonkeyRocket" should {
    "to be launched return a String with a default control panel configured" in {
      val service: SpaceMonkeyRocket = SpaceMonkeyRocket(DefaultSetup, 1 to 10)
      val rocketResult = service.launcherRocket(Some(goodMonkeys))
      rocketResult shouldBe SUCCESS
      service.setup shouldBe DefaultSetup
      service.countDown shouldBe (1 to 10)
    }
  }

  "SpaceMonkeyRocket" should {
    "throw an IllegalArgumentException for NoSetup" in {
      an[IAE] should be thrownBy SpaceMonkeyRocket(NoSetup, 1 to 10)
    }
  }

  "SpaceMonkeyRocket" should {
    "to be launched return a String without control panel configuration" in {
      val service: SpaceMonkeyRocket = SpaceMonkeyRocket(null, 1 to 10)
      val rocketResult = service.launcherRocket(Some(goodMonkeys))
      rocketResult shouldBe SUCCESS
      service.setup shouldBe DefaultSetup
      service.countDown shouldBe (1 to 10)
    }
  }

  "SpaceMonkeyRocket" should {
    "to be launched return a String with a default control panel configured and countdown to 20" in {
      val service: SpaceMonkeyRocket = SpaceMonkeyRocket(DefaultSetup, 1 to 20)
      val rocketResult = service.launcherRocket(Some(goodMonkeys))
      rocketResult shouldBe SUCCESS
      service.setup shouldBe DefaultSetup
      service.countDown shouldBe (1 to 20)
    }
  }

  "SpaceMonkeyRocket" should {
    "throw a MonkeyTouchingException" in {
      val service: SpaceMonkeyRocket = SpaceMonkeyRocket(DefaultSetup, 1 to 20)
      an[MTE] should be thrownBy service.launcherRocket(Some(badMonkeys))
    }
  }

//  // Why not?, I want to test my private auxiliary methods
//  "CheckSetup" should {
//    "return false because doesn't have setup" in {
//      val service = SpaceMonkeyRocket(DefaultSetup, 1 to 10)
//      val toInvokeMethod = PrivateMethod[Boolean]('checkSetup)
//      assert(false === service.invokePrivate(toInvokeMethod(NoSetup)))
//    }
//  }
//
//  "CheckSetup" should {
//    "return true because has defaultSetup" in {
//      val service = SpaceMonkeyRocket(DefaultSetup, 1 to 10)
//      val toInvokeMethod = PrivateMethod[Boolean]('checkSetup)
//      assert(true === service.invokePrivate(toInvokeMethod(DefaultSetup)))
//    }
//  }

  "AdjustSetupByMonkeyFault" should {
    "return a MonkeyTouchingException if is false as argument" in {
      val service = SpaceMonkeyRocket(DefaultSetup, 1 to 10)
      val toInvokeMethod = PrivateMethod[Boolean]('adjustSetupByMonkeyFault)
      an[MTE] should be thrownBy service.invokePrivate(toInvokeMethod(false))
    }
  }

}
