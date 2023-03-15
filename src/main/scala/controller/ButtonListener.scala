package controller

import javafx.event.{ActionEvent, EventHandler}
import model.{Battle, CharacterSample}
import view.BattleField

// Creates buttons for BattleField class
class ButtonListener() extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    Battle.firstButton()
    BattleField.createButtons("second",Battle.EnemyChar2)

  }
}

// Allows to reset everything by calling reset() function
class ResetListener() extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    Battle.reset()
  }
}

// Takes the power from your teams character and implements it on enemy
class PowerListener(power: String, character: CharacterSample,enemy: CharacterSample) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    Battle.takeAction(power,character,enemy)
  }
}

// Allows to animate between interactions
class AnimateListener() extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    Battle.animate("second","seconde", -5)
  }
}
