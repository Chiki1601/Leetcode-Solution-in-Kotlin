import kotlin.math.max

class Solution {

    private companion object {
        const val PLACEHOLDER_VALUE_FOR_FREE_TIME_BEFORE_FIRST_MEETING = -1
    }

    private val eventTimeRange = IntArray(2)
    private var totalNumberOfMeetings: Int = 0

    fun maxFreeTime(totalEventTime: Int, maxNumberOfMeetingsToReschedule: Int, startTime: IntArray, endTime: IntArray): Int {
        eventTimeRange[1] = totalEventTime
        totalNumberOfMeetings = startTime.size

        var maxFreeTime = 0
        var currentFreeTime = startTime[0]
        var numberOfFreeTimeIntervals = if (startTime[0] > eventTimeRange[0]) 1 else 0

        var frontIndex = 0
        var backIndex =
            if (startTime[0] > eventTimeRange[0]) PLACEHOLDER_VALUE_FOR_FREE_TIME_BEFORE_FIRST_MEETING else 0

        while (frontIndex < totalNumberOfMeetings) {

            if (numberOfFreeTimeIntervals < maxNumberOfMeetingsToReschedule + 1) {
                currentFreeTime += getValueToExpandFreeTime(startTime, endTime, frontIndex)
                ++frontIndex
                ++numberOfFreeTimeIntervals
            }

            maxFreeTime = max(maxFreeTime, currentFreeTime)

            if (numberOfFreeTimeIntervals == maxNumberOfMeetingsToReschedule + 1) {
                currentFreeTime -= getValueToShrinkFreeTime(startTime, endTime, backIndex)
                ++backIndex
                --numberOfFreeTimeIntervals
            }
        }
        return maxFreeTime
    }

    private fun getValueToExpandFreeTime(startTime: IntArray, endTime: IntArray, frontIndex: Int): Int {
        if (frontIndex + 1 < totalNumberOfMeetings) {
            return startTime[frontIndex + 1] - endTime[frontIndex]
        }
        return eventTimeRange[1] - endTime[frontIndex]
    }

    private fun getValueToShrinkFreeTime(startTime: IntArray, endTime: IntArray, backIndex: Int): Int {
        if (backIndex == PLACEHOLDER_VALUE_FOR_FREE_TIME_BEFORE_FIRST_MEETING) {
            return startTime[0]
        }
        return startTime[backIndex + 1] - endTime[backIndex]
    }
}
