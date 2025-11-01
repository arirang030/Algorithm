def solution(common):    
    d = common[1] - common[0]
    r = common[1] / common[0] if common[0] != 0 else 0
    return common[-1] + d if common[2] - common[1] == d else common[-1] * r