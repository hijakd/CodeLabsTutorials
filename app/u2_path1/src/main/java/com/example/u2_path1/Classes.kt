package com.example.u2_path1

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"
        protected set

    open val deviceType = "unknown"

    open fun turnOn() {
        if (deviceStatus != "on") {
            deviceStatus = "on"
        }
    }

    open fun turnOff() {
        if (deviceStatus != "off") {
            deviceStatus = "off"
        }
    }

    fun printDeviceStatus() {
        println("Device: $name's status is $deviceStatus")
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }

    fun notOn() {
        println("$name, is not turned on")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    /* using a property delegate */
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    /* using a property delegate */
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        if (deviceStatus == "on") {
            speakerVolume++
            println("Speaker volume increased to $speakerVolume.")
        } else {
            super.notOn()
        }
    }

    fun decreaseSpeakerVolume() {
        if (deviceStatus == "on") {
            speakerVolume--
            println("Speaker volume decreased to $speakerVolume.")
        } else {
            super.notOn()
        }
    }

    fun nextChannel() {
        if (deviceStatus == "on") {
            channelNumber++
            println("Channel number increased to $channelNumber.")
        } else {
            super.notOn()
        }
    }

    fun previousChannel() {
        if (deviceStatus == "on") {
            channelNumber--
            println("Channel number decreased to $channelNumber.")
        } else {
            super.notOn()
        }
    }

    override fun turnOn() {
        super.turnOn()
        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is " + "set to $channelNumber.")
    }

    override fun turnOff() {
//        if (deviceStatus == "on") {
        super.turnOff()
        println("$name turned off")
//        }
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        if (deviceStatus == "on") {
            brightnessLevel++
            println("Brightness increased to $brightnessLevel.")
        } else {
            super.notOn()
        }
    }

    fun decreaseBrightness() {
        if (deviceStatus == "on") {
            brightnessLevel--
            println("Brightness decreased to $brightnessLevel.")
        } else {
            super.notOn()
        }
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        if (deviceStatus == "on") {
            super.turnOff()
            brightnessLevel = 0
            println("Smart Light turned off")
        } else {
            super.notOn()
        }
    }
}

class SmartHome(val smartTvDevice: SmartTvDevice, val smartLightDevice: SmartLightDevice) {

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        if (deviceTurnOnCount > 0) {
            deviceTurnOnCount--
        }
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun changeTvChannelToPrevious() {
        smartTvDevice.previousChannel()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        if (deviceTurnOnCount > 0) {
            deviceTurnOnCount--
        }
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun decreaseLightBrightness() {
        smartLightDevice.decreaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }

    fun printSmartTvInfo() {
        println("SmartTv name: ${smartTvDevice.name}, category: ${smartTvDevice.category}, type: ${smartTvDevice.deviceType}")
    }

    fun printSmartLightInfo() {
        println("SmartLight name: ${smartLightDevice.name}, category: ${smartLightDevice.category}, type: ${smartLightDevice.deviceType}")
    }
}

/* this is a property delegate */
class RangeRegulator(initialValue: Int, private val minValue: Int, private val maxValue: Int
                    ) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()
    smartDevice.printDeviceInfo()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
    println("...")

    val smartTv = SmartTvDevice("2nd Android TV", "Entertainment")
    smartTv.printDeviceStatus()
    smartTv.turnOn()
    smartTv.printDeviceInfo()
    smartTv.printDeviceStatus()
    smartTv.increaseSpeakerVolume()
    smartTv.nextChannel()
    smartTv.turnOff()
    smartTv.increaseSpeakerVolume()

    println("...")

    val smartLight = SmartLightDevice("2nd Google Light", "Utility")
    smartLight.printDeviceStatus()
    smartLight.turnOn()
    smartLight.increaseBrightness()
    smartLight.turnOff()

    println("...")

    val smartHome = SmartHome(smartTvDevice = SmartTvDevice("3rd Android TV", "Entertainment"),
                              smartLightDevice = SmartLightDevice("3rd Google Light", "Utility"))

    smartHome.printSmartTvInfo()
    smartHome.printSmartLightInfo()
    println("...")
    smartHome.increaseTvVolume()
    smartHome.turnOnTv()
    smartHome.changeTvChannelToNext()
    smartHome.increaseTvVolume()
    smartHome.turnOnLight()
    smartHome.smartLightDevice.increaseBrightness()
    smartHome.decreaseLightBrightness()
    println("...")
    smartHome.turnOffAllDevices()
}