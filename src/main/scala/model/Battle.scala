package model

import model.Testing.{fromJSON, createMap}
import view.BattleField
import scalafx.scene.paint.Color._

// Uses dataMap for characters to store information/ reset to get back to original stats/ animate to animate the inbetween actions
object Battle {
  //general information for characters and parties

  var string =
    """{"playerParty":{"characters": [{"name":"first", "hp":50, "maxHP":50,
      | "battleOptions": ["","","",""]},{"name":"second", "hp":40, "maxHP":50,
      | "battleOptions": ["heal","attack","nothing","nothing again"]},{"name":"third", "hp":50, "maxHP":50,
      | "battleOptions": ["","","",""]},{"name":"fourth", "hp":50, "maxHP":50,
      | "battleOptions": ["","","",""]}]},"enemyParty":{"characters": [{"name":"firsten", "hp":0, "maxHP":50,
      | "battleOptions": ["","","",""]},{"name":"seconde", "hp":45, "maxHP":50,
      | "battleOptions": ["","","",""]},{"name":"thirde", "hp":50, "maxHP":50,
      | "battleOptions": ["","","",""]},{"name":"fourthe", "hp":50, "maxHP":50,
      | "battleOptions": ["","","",""]}]}}""".stripMargin


  var data = fromJSON(string)
  var dataMap = createMap(data)
  var party = data(0)
  var enemyParty = data(1)


  var char1 = party(0)
  var char2 = party(1)
  var char3 = party(2)
  var char4 = party(3)

  var char5 = enemyParty(0)
  var char6 = enemyParty(1)
  var char7 =enemyParty(2)
  var char8 = enemyParty(3)


  // First button
  def firstButton(): Unit = {
    view.BattleField.content2.layoutY = view.BattleField.fieldY / 3
    view.BattleField.content6.layoutY = view.BattleField.fieldY / 3
    println("Button was Activated")

  }

  //Reset for original stats
  def reset(): Unit ={
    Battle.string =
      """{"playerParty":{"characters": [{"name":"first", "hp":50, "maxHP":50, "battleOptions": ["","","",""]},{"name":"second", "hp":50, "maxHP":50,
        | "battleOptions": ["attack","heal","nothing","nothing2"]},{"name":"third", "hp":50, "maxHP":50, "battleOptions": ["","","",""]},{"name":"fourth", "hp":50, "maxHP":50,
        | "battleOptions": ["","","",""]}]},"enemyParty":{"characters": [{"name":"firste", "hp":50, "maxHP":50,
        | "battleOptions": ["","","",""]},{"name":"seconde", "hp":50, "maxHP":50, "battleOptions": ["","","",""]},{"name":"thirde", "hp":50, "maxHP":50,
        | "battleOptions": ["","","",""]},{"name":"fourthe", "hp":50, "maxHP":50, "battleOptions": ["","","",""]}]}}""".stripMargin

    data = fromJSON(string)
    char1 = party(0)
    char2 = party(1)
    char3 = party(2)
    char4 = party(3)

    char5 = enemyParty(0)
    char5.hp = char5.maxHP
    char6 = enemyParty(1)
    char7 =enemyParty(2)
    char8 = enemyParty(3)

    BattleField.drawcharacters()

    BattleField.hppy.text = char5.maxHP.toString + "/" + char5.maxHP.toString
    BattleField.enemy.fill = Red

  }

  //Fighting mechanics
  def takeAction(power: String, character: CharacterSample, enemy: CharacterSample): Unit = {
    if (power == "nothing"){

    }else if(power == "attack"){
      animate("second","seconde", -10)

    }else if(power == "heal"){
      animate("second","seconde", 10)

    }
    BattleField.drawcharacters()
  }

  //Animate function
  def animate(chars1: String, chars2: String, attack: Int): Unit = {

    //Attack
    if (attack < 0){
      var first: CharacterSample = dataMap(chars1)
      var second: CharacterSample = dataMap(chars2)

      second.hp += attack
      second.hp = Math.max(second.hp, 0)

    //Heal
    }else if (attack > 0){
      var first: CharacterSample = dataMap(chars1)
      val second: CharacterSample = dataMap(chars2)

      if(first.hp< first.maxHP){
        first.hp += attack
        first.hp = Math.min(first.hp, first.maxHP)
      }else{
        second.hp +=attack
        second.hp = Math.min(second.hp, second.maxHP)
      }

    }else {

    }
  }



  // var state = new Begin()
  // takeTurn() = String(character name) => my character "change location"

  def main(args: Array[String]): Unit = {

  }
}

