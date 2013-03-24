package com.aethercraft.moba

case class MOBACraftException(msg: String, e: Exception) extends RuntimeException(msg, e)