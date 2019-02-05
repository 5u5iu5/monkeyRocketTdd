package com.tdd.monkeyrocket

import com.tdd.monkeyrocket.Setup.{DefaultSetup, NoSetup}
import org.scalatest.{Matchers, PrivateMethodTester, WordSpec}

class SpaceMonkeyRocketSpec extends WordSpec with Matchers with PrivateMethodTester {

  "SpaceMonkeyRocket" should {
    "to be launched return true with 2 monkeys and default control panel configured" in {
      val service: SpaceMonkeyRocket = SpaceMonkeyRocket(DefaultSetup)
      val rocketResult = service.launcherRocket
      rocketResult shouldBe true
    }
  }

  "SpaceMonkeyRocket" should {
    "return false because doesn't have setup" in {
      val service: SpaceMonkeyRocket = SpaceMonkeyRocket(NoSetup)
      val rocketResult = service.launcherRocket
      rocketResult shouldBe false
    }
  }

  // Why not?, I want to test my private auxiliary methods
  "CheckSetup" should {
    "return false because doesn't have setup" in {
      val service = SpaceMonkeyRocket(DefaultSetup)
      val toInvokeMethod = PrivateMethod[Boolean]('checkSetup)
      assert(false === service.invokePrivate(toInvokeMethod(NoSetup)))
    }
  }

  "CheckSetup" should {
    "return true because has defaultSetup" in {
      val service = SpaceMonkeyRocket(DefaultSetup)
      val toInvokeMethod = PrivateMethod[Boolean]('checkSetup)
      assert(true === service.invokePrivate(toInvokeMethod(DefaultSetup)))
    }
  }

  "AdjustSetupByMonkeyFault" should {
    "return true if is false as argument" in {
      val service = SpaceMonkeyRocket(DefaultSetup)
      val toInvokeMethod = PrivateMethod[Boolean]('adjustSetupByMonkeyFault)
      assert(true === service.invokePrivate(toInvokeMethod(false)))
    }
  }
}
