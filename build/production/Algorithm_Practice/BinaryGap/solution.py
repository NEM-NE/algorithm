def solution(N):
    binary = format(N, 'b').strip('0').split('1')
    cnt = max([len(cur) for cur in binary])
    return cnt;