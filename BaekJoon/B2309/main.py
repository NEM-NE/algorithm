import sys
from functools import reduce


def solution():
    # input
    height_list = []
    i = 0
    while i != 9:
        height = int(input())
        height_list.append(height)
        i += 1

    # calculate
    recursive(height_list, 0, [])


def recursive(height_list: list, idx: int, actual_list: list):
    if len(actual_list) == 7:
        isValid, list = isValidSum(actual_list)
        if isValid:
            for i in list:
                print(i)
            sys.exit()
        return

    for i in range(idx, len(height_list)):
        actual_list.append(height_list[i])
        recursive(height_list, idx + 1, actual_list)
        actual_list.pop()

    return


def isValidSum(actual_list: list):
    result = reduce(lambda x, y: x + y, actual_list)
    if result == 100:
        actual_list.sort()
        return True, actual_list

    return False, actual_list


solution()
