package com.tdd.monkeyrocket

object Setup {
  sealed abstract class ControlPanelSetup
  case object DefaultSetup extends ControlPanelSetup
  case object MediumSetup extends ControlPanelSetup
  case object ComplexSetup extends ControlPanelSetup
  case object CrazySetup extends ControlPanelSetup
  case object NoSetup extends ControlPanelSetup
}
