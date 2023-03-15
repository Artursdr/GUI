package model

import model.Battle
import play.api.libs.json.{JsValue, Json}
import scala.collection.mutable.{ListBuffer, Map}

// Tests
object Testing {

  var data1: String =
    """{"playerParty":{"characters": [
      |{"name":"Archer", "hp":50, "maxHP":50, "battleOptions": ["","","",""]},
      |{"name":"second", "hp":40, "maxHP":50, "battleOptions": ["heal","attack","nothing","nothing again"]},
      |{"name":"third", "hp":50, "maxHP":50, "battleOptions": ["","","",""]},
      |{"name":"fourth", "hp":50, "maxHP":50, "battleOptions": ["","","",""]}]},
      |"enemyParty":{"characters": [
      |{"name":"firsten", "hp":0, "maxHP":50, "battleOptions": ["","","",""]},
      |{"name":"seconde", "hp":45, "maxHP":50, "battleOptions": ["","","",""]},
      |{"name":"thirde", "hp":50, "maxHP":50, "battleOptions": ["","","",""]},
      |{"name":"fourthe", "hp":50, "maxHP":50, "battleOptions": ["","","",""]}]}}""".stripMargin

  var myParty: List[CharacterSample] = List()
  var enemy: List[CharacterSample] = List()

  def fromJSON(jString: String): ListBuffer[ListBuffer[CharacterSample]] = {
    var result: ListBuffer[ListBuffer[CharacterSample]] = ListBuffer()

    val parsed: JsValue = Json.parse(jString)
    val party = (parsed \ "playerParty"\ "characters").as[List[JsValue]]
    val enemyParty = (parsed \ "enemyParty" \ "characters").as[List[JsValue]]

    //.as[Map[String, CharacterSample]]

    var partyList: ListBuffer[CharacterSample] = ListBuffer()
    for(charOne <- party){
      val name = (charOne\ "name").as[String]
      var hp = (charOne \ "hp").as[Int]
      val maxHP = (charOne \ "maxHP").as[Int]
      val battleOptions = (charOne \ "battleOptions").as[List[String]]

      val character = new CharacterSample(name,hp, maxHP, battleOptions)
      partyList += character
    }

    result += partyList

    println(partyList)

    var enemyList: ListBuffer[CharacterSample] = ListBuffer()

    for(charOne <- enemyParty){

      val name = (charOne\ "name").as[String]
      var hp = (charOne \ "hp").as[Int]
      val maxHP = (charOne \ "maxHP").as[Int]
      val battleOptions = (charOne \ "battleOptions").as[List[String]]

      val character = new CharacterSample(name,hp, maxHP, battleOptions)
      enemyList += character

    }

    result += enemyList
    result

  }

  def createMap(input: ListBuffer[ListBuffer[CharacterSample]]): Map[String,CharacterSample] ={

    var resultMap: Map[String,CharacterSample] = Map()
    for(party <- input){
      for (char <- party){
        resultMap += (char.name -> char)

      }
    }

    resultMap

  }

  def main(args: Array[String]): Unit = {

    var data = fromJSON(data1)
    println(data)

  }
}
