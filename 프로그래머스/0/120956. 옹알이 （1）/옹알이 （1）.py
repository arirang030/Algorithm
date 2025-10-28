def solution(babbling):
    
    answer = 0
    
    a = ["aya", "woo"]
    b = ["ye", "ma"]

    for x in babbling:
        if x in a or x in b:
            answer += 1
            continue
        if x[:3] in a:
            answer += solution([x[3:]])
        elif x[:2] in b:
            answer += solution([x[2:]])
    
    return answer