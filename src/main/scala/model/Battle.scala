package model

import model.Testing.{fromJSON, createMap}
import view.BattleField
import scalafx.scene.paint.Color._

// Uses dataMap for characters to store information/ reset to get back to original stats/ animate to animate the inbetween actions
object Battle {
  //general information for characters and parties

  var string =
    """{"playerParty":{"characters": [
      |{"name":"Archer", "hp":50, "maxHP":50, "battleOptions": ["","","",""]},
      |{"name":"Healer", "hp":20, "maxHP":50, "battleOptions": ["Heal","Attack","Other","Another"]},
      |{"name":"Tank", "hp":50, "maxHP":50, "battleOptions": ["","","",""]},
      |{"name":"Fighter", "hp":50, "maxHP":50, "battleOptions": ["","","",""]}]},
      |"enemyParty":{"characters": [
      |{"name":"EArcher", "hp":0, "maxHP":50, "battleOptions": ["","","",""]},
      |{"name":"EHealer", "hp":45, "maxHP":50, "battleOptions": ["","","",""]},
      |{"name":"ETank", "hp":50, "maxHP":50, "battleOptions": ["","","",""]},
      |{"name":"EFighter", "hp":50, "maxHP":50, "battleOptions": ["","","",""]}]}}""".stripMargin


  var data = fromJSON(string)
  var dataMap = createMap(data)
  var party = data(0)
  var enemyParty = data(1)


  var YourChar1 = party(0)
  var YourChar2 = party(1)
  var YourChar3 = party(2)
  var YourChar4 = party(3)

  var EnemyChar1 = enemyParty(0)
  var EnemyChar2 = enemyParty(1)
  var EnemyChar3 =enemyParty(2)
  var EnemyChar4 = enemyParty(3)


  // First button
  def firstButton(): Unit = {
    view.BattleField.content2.layoutY = view.BattleField.fieldY / 3
    view.BattleField.content6.layoutY = view.BattleField.fieldY / 3
    println("Button was Activated")

  }

  //Reset for original stats
  def reset(): Unit ={
    Battle.string =
      """{"playerParty":{"characters": [
        |{"name":"Archer", "hp":50, "maxHP":50, "battleOptions": ["","","",""]},
        |{"name":"Healer", "hp":20, "maxHP":50, "battleOptions": ["Heal","Attack","Other","Another"]},
        |{"name":"Tank", "hp":50, "maxHP":50, "battleOptions": ["","","",""]},
        |{"name":"Fighter", "hp":50, "maxHP":50, "battleOptions": ["","","",""]}]},
        |"enemyParty":{"characters": [
        |{"name":"EArcher", "hp":0, "maxHP":50, "battleOptions": ["","","",""]},
        |{"name":"EHealer", "hp":45, "maxHP":50, "battleOptions": ["","","",""]},
        |{"name":"ETank", "hp":50, "maxHP":50, "battleOptions": ["","","",""]},
        |{"name":"EFighter", "hp":50, "maxHP":50, "battleOptions": ["","","",""]}]}}""".stripMargin

    data = fromJSON(string)
    YourChar1 = party(0)
    YourChar2 = party(1)
    YourChar3 = party(2)
    YourChar4 = party(3)

    EnemyChar1 = enemyParty(0)
    EnemyChar1.hp = EnemyChar1.maxHP
    EnemyChar2 = enemyParty(1)
    EnemyChar3 =enemyParty(2)
    EnemyChar4 = enemyParty(3)

    BattleField.drawcharacters()

    BattleField.hppy.text = EnemyChar1.maxHP.toString + "/" + EnemyChar1.maxHP.toString
    BattleField.enemy.fill = Red

  }

  //Fighting mechanics
  def takeAction(power: String, character: CharacterSample, enemy: CharacterSample): Unit = {
    if (power == "other"){

    }else if(power == "Attack"){
      animate("Healer","EHealer", -10)

    }else if(power == "Heal"){
      animate("Healer","EHealer", 10)

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

