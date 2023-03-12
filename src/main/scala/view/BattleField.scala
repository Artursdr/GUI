package view

import controller.{AnimateListener, ButtonListener, PowerListener, ResetListener}
import javafx.geometry.Pos
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.paint.Color._
import scalafx.scene.{Group, Scene}
import scalafx.scene.control.Button
import scalafx.scene.layout.{HBox, Pane, VBox}
import scalafx.scene.shape.Rectangle
import scalafx.scene.text.Text
import model.Battle.{char1, char2, char3, char4, char5, char6, char7, char8, dataMap, enemyParty, party, string}
import model.CharacterSample
import model.Testing.{enemy, fromJSON}
import scalafx.animation.AnimationTimer
import scalafx.scene.paint.Color
import scala.collection.mutable.ListBuffer

// BattleField Build

object BattleField extends JFXApp {

  //Battlefield layout
  val fieldX: Int = 800
  val fieldY: Int = 600
  val sqX: Int = 40
  val sqY: Int = 50

  //Groups
  var partyGraphics: Group = new Group{}
  var battleButtons: Group = new Group{}


  //Your Character Party

  var firstPlayer = new Rectangle {
    width = sqX
    height = sqY
    if (char1.hp == 0) {
      fill = Black
    } else fill = Red
  }

  var name = new Text {
    text = char1.name
    style = "-fx-font-size: 12pt"
    fill = Black
  }
  var hpp = new Text {
    text = char1.hp.toString + "/" + char1.maxHP.toString
    style = "-fx-font-size: 12pt"
    fill = Black
  }

  var secondPlayer = new Rectangle {
    width = sqX
    height = sqY
    if (char2.hp == 0) {
      fill = Black
    } else fill = Red

  }
  var name2 = new Text {
    text = char2.name
    style = "-fx-font-size: 12pt"
    fill = Black
  }
  var hpp2 = new Text {
    text = char2.hp.toString + "/" + char2.maxHP.toString
    style = "-fx-font-size: 12pt"
    fill = Black
  }

  var thirdPlayer = new Rectangle {
    width = sqX
    height = sqY
    if (char3.hp == 0) {
      fill = Black
    } else fill = Red
  }

  var name3 = new Text {
    text = char3.name
    style = "-fx-font-size: 12pt"
    fill = Black
  }
  var hpp3 = new Text {
    text = char3.hp.toString + "/" + char3.maxHP.toString
    style = "-fx-font-size: 12pt"
    fill = Black
  }

  var fourthPlayer = new Rectangle {
    width = sqX
    height = sqY
    if (char4.hp == 0) {
      fill = Black
    } else fill = Red
  }
  var name4 = new Text {
    text = char4.name
    style = "-fx-font-size: 12pt"
    fill = Black
  }
  var hpp4 = new Text {
    text = char4.hp.toString + "/" + char1.maxHP.toString
    style = "-fx-font-size: 12pt"
    fill = Black
  }

  //Layout for Your Character Party

  var contents = new VBox {
    children = List(name, hpp, firstPlayer)
    layoutX = fieldX / 16
    layoutY = fieldY - 300
  }


  var content2 = new VBox {
    children = List(name2, hpp2, secondPlayer)
    layoutX = fieldX / 16 + fieldX / 10
    layoutY = fieldY - 300
  }


  var content3 = new VBox {
    children = List(name3, hpp3, thirdPlayer)
    layoutX = fieldX / 16 + fieldX / 10 + fieldX / 10
    layoutY = fieldY - 300
  }


  var content4 = new VBox{
    children = List(name4, hpp4, fourthPlayer)
    layoutX = fieldX / 16 + fieldX / 10 + fieldX / 10 + fieldX / 10
    layoutY = fieldY - 300}


  //Enemy Character Party

  //First Enemy

  var enemy = new Rectangle {
    width = sqX
    height = sqY
    if (char5.hp == 0){
      fill = Black
    }else fill = Red
  }

  var naame = new Text {
    text = char5.name
    style = "-fx-font-size: 12pt"
    fill = Black
  }
  var hppy = new Text {
    text = char5.hp.toString + "/" + char5.maxHP.toString
    style = "-fx-font-size: 12pt"
    fill = Black
  }
  var content5 = new VBox {
    children = List( naame, hppy, enemy)
    layoutX = fieldX - fieldX /16 -30
    layoutY = fieldY - 300
  }

  //Second Enemy
  var enemy2 = new Rectangle {
    width = sqX
    height = sqY
    if (char6.hp == 0){
      fill = Black
    }else fill = Red
  }

  var naame2 = new Text {
    text = char6.name
    style = "-fx-font-size: 12pt"
    fill = Black
  }
  var hppy2 = new Text {
    text = char6.hp.toString + "/" + char1.maxHP.toString
    style = "-fx-font-size: 12pt"
    fill = Black
  }
  var content6 = new VBox {
    children = List(naame2, hppy2, enemy2)
    layoutX = fieldX - fieldX /16 - fieldX /10 - 30
    layoutY = fieldY - 300
  }

  //Third enemy
  var enemy3 = new Rectangle {
    width = sqX
    height = sqY
    if (char7.hp == 0){
      fill = Black
    }else fill = Red
  }

  var naame3 = new Text {
    text = char7.name
    style = "-fx-font-size: 12pt"
    fill = Black
  }
  var hppy3 = new Text {
    text = char7.hp.toString + "/" + char7.maxHP.toString
    style = "-fx-font-size: 12pt"
    fill = Black
  }
  var content7 = new VBox {
    children = List(naame3, hppy3, enemy3)
    layoutX = fieldX - fieldX /16 - fieldX /10 - fieldX /10 -30
    layoutY = fieldY - 300
  }

  //Fourth enemy
  var enemy4 = new Rectangle {
    width = sqX
    height = sqY
    if (char8.hp == 0){
      fill = Black
    }else fill = Red
  }

  var naame4 = new Text {
    text = char8.name
    style = "-fx-font-size: 12pt"
    fill = Black
  }
  var hppy4 = new Text {
    text = char8.hp.toString + "/" + char8.maxHP.toString
    style = "-fx-font-size: 12pt"
    fill = Black
  }
  var content8 = new VBox {
    children = List(naame4, hppy4, enemy4)
    layoutX = fieldX - fieldX /16  - fieldX /10 - fieldX /10 - fieldX /10 - 30
    layoutY = fieldY - 300
  }

  //PartyGraphics
  partyGraphics.children.add(contents)
  partyGraphics.children.add(content2)
  partyGraphics.children.add(content3)
  partyGraphics.children.add(content4)
  partyGraphics.children.add(content5)
  partyGraphics.children.add(content6)
  partyGraphics.children.add(content7)
  partyGraphics.children.add(content8)

  //Hp system visual
  def drawcharacters(): Unit = {

    partyGraphics = new Group()

    //First Character
    var firstPlayer = new Rectangle {
      width = sqX
      height = sqY
      if (char1.hp == 0) {
        fill = Black
      } else fill = Red
    }

    var name = new Text {
      text = char1.name
      style = "-fx-font-size: 12pt"
      fill = Black
    }

    var hpp = new Text {
      text = char1.hp.toString + "/" + char1.maxHP.toString
      style = "-fx-font-size: 12pt"
      fill = Black
    }

    //Second Character
    var secondPlayer = new Rectangle {
      width = sqX
      height = sqY
      if (char2.hp == 0) {
        fill = Black
      } else fill = Red

    }

    var name2 = new Text {
      text = char2.name
      style = "-fx-font-size: 12pt"
      fill = Black
    }

    var hpp2 = new Text {
      text = char2.hp.toString + "/" + char2.maxHP.toString
      style = "-fx-font-size: 12pt"
      fill = Black
    }

    var thirdPlayer = new Rectangle {
      width = sqX
      height = sqY
      if (char3.hp == 0) {
        fill = Black
      } else fill = Red
    }

    //Third Character
    var name3 = new Text {
      text = char3.name
      style = "-fx-font-size: 12pt"
      fill = Black
    }

    var hpp3 = new Text {
      text = char3.hp.toString + "/" + char3.maxHP.toString
      style = "-fx-font-size: 12pt"
      fill = Black
    }

    //Fourth Character
    var fourthPlayer = new Rectangle {
      width = sqX
      height = sqY
      if (char4.hp == 0) {
        fill = Black
      } else fill = Red
    }

    var name4 = new Text {
      text = char4.name
      style = "-fx-font-size: 12pt"
      fill = Black
    }

    var hpp4 = new Text {
      text = char4.hp.toString + "/" + char1.maxHP.toString
      style = "-fx-font-size: 12pt"
      fill = Black
    }

    //Placement

    //First Character
    var contents = new VBox {
      children = List(name, hpp, firstPlayer)
      layoutX = fieldX / 16
      layoutY = fieldY - 300
    }

    //Second Character
    var content2 = new VBox {
      children = List(name2, hpp2, secondPlayer)
      layoutX = fieldX / 16 + fieldX / 10
      layoutY = fieldY - 300
    }

    //Third Character
    var content3 = new VBox {
      children = List(name3, hpp3, thirdPlayer)
      layoutX = fieldX / 16 + fieldX / 10 + fieldX / 10
      layoutY = fieldY - 300
    }

    //Fourth Character
    var content4 = new VBox{
      children = List(name4, hpp4, fourthPlayer)
      layoutX = fieldX / 16 + fieldX / 10 + fieldX / 10 + fieldX / 10
      layoutY = fieldY - 300}


    // Enemy Party Characters

    //First Enemy Character
    var enemy = new Rectangle {
      width = sqX
      height = sqY
      if (char5.hp == 0){
        fill = Black
      }else fill = Red
    }

    var naame = new Text {
      text = char5.name
      style = "-fx-font-size: 12pt"
      fill = Black
    }
    var hppy = new Text {
      text = char5.hp.toString + "/" + char5.maxHP.toString
      style = "-fx-font-size: 12pt"
      fill = Black
    }
    var content5 = new VBox {
      children = List( naame, hppy, enemy)
      layoutX = fieldX - fieldX /16 -30
      layoutY = fieldY - 300
    }

    //Second Enemy Character
    var enemy2 = new Rectangle {
      width = sqX
      height = sqY
      if (char6.hp == 0){
        fill = Black
      }else fill = Red
    }

    var naame2 = new Text {
      text = char6.name
      style = "-fx-font-size: 12pt"
      fill = Black
    }
    var hppy2 = new Text {
      text = char6.hp.toString + "/" + char1.maxHP.toString
      style = "-fx-font-size: 12pt"
      fill = Black
    }
    var content6 = new VBox {
      children = List(naame2, hppy2, enemy2)
      layoutX = fieldX - fieldX /16 - fieldX /10 - 30
      layoutY = fieldY - 300
    }

    //Third Enemy Character
    var enemy3 = new Rectangle {
      width = sqX
      height = sqY
      if (char7.hp == 0){
        fill = Black
      }else fill = Red
    }

    var naame3 = new Text {
      text = char7.name
      style = "-fx-font-size: 12pt"
      fill = Black
    }
    var hppy3 = new Text {
      text = char7.hp.toString + "/" + char7.maxHP.toString
      style = "-fx-font-size: 12pt"
      fill = Black
    }
    var content7 = new VBox {
      children = List(naame3, hppy3, enemy3)
      layoutX = fieldX - fieldX /16 - fieldX /10 - fieldX /10 -30
      layoutY = fieldY - 300
    }

    //Fourth Enemy Character
    var enemy4 = new Rectangle {
      width = sqX
      height = sqY
      if (char8.hp == 0){
        fill = Black
      }else fill = Red
    }

    var naame4 = new Text {
      text = char8.name
      style = "-fx-font-size: 12pt"
      fill = Black
    }
    var hppy4 = new Text {
      text = char8.hp.toString + "/" + char8.maxHP.toString
      style = "-fx-font-size: 12pt"
      fill = Black
    }
    var content8 = new VBox {
      children = List(naame4, hppy4, enemy4)
      layoutX = fieldX - fieldX /16  - fieldX /10 - fieldX /10 - fieldX /10 - 30
      layoutY = fieldY - 300
    }


    partyGraphics.children.add(contents)
    partyGraphics.children.add(content2)
    partyGraphics.children.add(content3)
    partyGraphics.children.add(content4)
    partyGraphics.children.add(content5)
    partyGraphics.children.add(content6)
    partyGraphics.children.add(content7)
    partyGraphics.children.add(content8)

    battleButtons = new Group{}

    stage = new PrimaryStage {
      title = "Battle field"
      width = fieldX
      height = fieldY
      //add x/y values in scene(x,y)
      scene = new Scene() {
        root = new Pane{
          fill = Green
          children = List(partyGraphics,buttons,battleButtons)
        }
      }
    }

  }


  def createButtons(charName: String, enemy: CharacterSample ): Unit = {
    val character = dataMap(charName)
    val battleList = character.battleOptions
    var buttonsList: ListBuffer[Button] = new ListBuffer()

    for (power <- battleList) {
      val powerButton = new Button {
        minWidth = 30
        minHeight = 20
        style = "-fx-font-size: 12pt"
        text = power.toString
        onAction = new PowerListener(power, character, enemy)
      }
      buttonsList += powerButton
    }

    val battleButton: HBox = new HBox {
      layoutX = fieldX / 8
      layoutY = fieldY - 100
      children = buttonsList.toList


    }

    battleButtons.children.add(battleButton)

  }



  val button = new Button{
    minWidth = 30
    minHeight = 20
    style = "-fx-font-size: 12pt"
    text = "Take turn"
    onAction  = new ButtonListener()
  }
  val resetButton = new Button{
    minWidth = 30
    minHeight = 20
    style = "-fx-font-size: 12pt"
    text = "Reset"
    onAction  = new ResetListener()
  }

  val animateButton = new Button{
    minWidth = 30
    minHeight = 20
    style = "-fx-font-size: 12pt"
    text = "Animate"
    onAction  = new AnimateListener()
  }
  val buttons = new HBox{
    layoutX = fieldX - fieldX/3
    layoutY = fieldY - 100
    children = List(button,resetButton)

  }


  //drawcharacters()
  // Group new group
  stage = new PrimaryStage {
    title = "Battle field"
    width = fieldX
    height = fieldY
    //add x/y values in scene(x,y)
    scene = new Scene() {
      fill = Color.Green
      root = new Pane{
        fill = Color.LightGreen
        children = List(partyGraphics,buttons,battleButtons)
      }
    }
  }


  var lastUpdateTime: Long = System.nanoTime()
  def update(time: Long):  Unit =  {
    val dt: Double = (time - lastUpdateTime) / 1000000000.0
    lastUpdateTime = time
    if (dt >2){
      drawcharacters()
    }
  }



  AnimationTimer(update).start()

}
