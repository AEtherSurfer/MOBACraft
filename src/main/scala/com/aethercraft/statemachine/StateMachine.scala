package com.aethercraft.statemachine

abstract class StateModel[S <: State[_,_]] {
  var state: S = _
  
}

abstract class State[M <: StateModel[S], S <: State[_,_]](model: StateModel[S]) {
  def enter() {}
  def exit(nextState: S) {
    println("Exiting " + this)
    model.state = nextState
    println("Entering " + nextState)
    nextState.enter()
  }
}

class StateMachineException(msg: String) extends RuntimeException(msg)