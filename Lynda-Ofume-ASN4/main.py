
#class creation
class Transmission:
    def __init__(self, name,retryTimes):
        self.nextTransmissionTime = 0
        self.retryCount = 0
        self.name = name
        self.retryTimes = retryTimes


file = open("input.txt", "r")
count = file.readline()
print("The number of stations in the network under investigation is:\n " + count)
transmissions = []

# read the input and create the class objects
for x in range(int(count)):
    retryTimes = file.readline().split(',')
    retryTimesInts = [int(numeric_string) for numeric_string in retryTimes]
    transmissions.append(Transmission("Station" + str((x+1)), retryTimesInts))

#print the random timeslots for the stations
print("The random numbers used by the stations are:")
for x in transmissions:
    print("\n", end="")
    for y in x.retryTimes:
        print(y, end=",")
        

print("\n")


stationsLeftToTransmit = int(count)
currentTimeSlot = 0

while stationsLeftToTransmit > 0:
    transmittingThisFrame=[]

    # Check failure condition: if a station has retried 5 times, print its components,
    # delete from stations to check, and decrement the station counter
    for x in transmissions:
        if x.retryCount == 5:
            print(x.name + ": Failure")
            print("Timeslot for Last Retransmission: " + str(x.nextTransmissionTime))
            print("Total Number of Retransmissions: 5")
            print(" ")
            stationsLeftToTransmit -= 1
            del x
            
    # check who wants to transmit this frame
    for x in transmissions:
        if x.nextTransmissionTime == currentTimeSlot:
            transmittingThisFrame.append(x)
            
    # If there is only one to transmit, it succeeds
    if len(transmittingThisFrame) == 1:
        print(transmittingThisFrame[0].name + ": Success")
        print("Timeslot for Successful Retransmission: " + str(currentTimeSlot))
        print("Total Number of Retransmissions:" + str(transmittingThisFrame[0].retryCount))
        print(" ")
        stationsLeftToTransmit -= 1
        
    # Otherwise, all transmissions this frame fail. Increment their retry counters and set next trans time
    else:
        for x in transmittingThisFrame:
            x.retryCount += 1
            x.nextTransmissionTime = x.nextTransmissionTime + x.retryTimes.pop(0)+1
    currentTimeSlot += 1





