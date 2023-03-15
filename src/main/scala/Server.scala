import akka.actor.{Actor, ActorRef, ActorSystem, PoisonPill, Props}
import com.corundumstudio.socketio.listener.{DataListener, DisconnectListener}
import com.corundumstudio.socketio.{AckRequest, Configuration, SocketIOClient, SocketIOServer}
import play.api.libs.json.{JsValue, Json}

class Server extends Actor {

  var actorRefToSocket: Map[ActorRef, SocketIOClient] = Map()
  var socketToActorRef: Map[SocketIOClient, ActorRef] = Map()




  val config: Configuration = new Configuration {
    setHostname("localhost")
    setPort(8080)
  }
  val server: SocketIOServer = new SocketIOServer(config)

  server.addDisconnectListener(new DisconnectionListener(this))
  server.start()


  override def receive: Receive = ???

  class DisconnectionListener(server: Server) extends DisconnectListener {
    override def onDisconnect(socket: SocketIOClient): Unit = {
      if(server.socketToActorRef.contains(socket)){
        server.socketToActorRef(socket) ! PoisonPill
        val username = server.socketToActorRef(socket)
        server.socketToActorRef -= socket
        server.actorRefToSocket -= username
        println("Disconnected")
      }
    }
  }

  override def postStop(): Unit = {
  println("Stopping server")
   server.stop()
  }

}
