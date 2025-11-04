def solution(quiz):
    answer = []
    
    for i in range(len(quiz)):
        a = quiz[i].split()
        num = list(map(int, a[::2]))
        if ((a[1] == "+" and num[0] + num[1] == num[2]) or 
            (a[1] == "-" and num[0] - num[1] == num[2])):
            answer.append("O")
        else:
            answer.append("X")
    
    return answer