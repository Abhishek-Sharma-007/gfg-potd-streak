from typing import List

def start_station(gas: List[int], cost: List[int]) -> int:
    if sum(gas) < sum(cost):
        return -1
    tank = 0
    start = 0
    for i in range(len(gas)):
        tank += gas[i] - cost[i]
        if tank < 0:
            start = i + 1
            tank = 0
    return start

if __name__ == "__main__":
    print(start_station([4,5,7,4], [6,6,3,5]))  # 2
    print(start_station([3,9], [7,6]))          # -1


