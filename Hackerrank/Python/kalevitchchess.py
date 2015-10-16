board = []
for i in range(8):
  board.append(raw_input())

result = 0
for i in range(8):
  if board[i][0] == 'B':
    for j in range(8):
      if board[i][j] == 'W':
        break
    if j == 7 and board[i][j] == 'B':
      result += 1

for j in range(8):
  if board[0][j] == 'B':
    for i in range(8):
      if board[i][j] == 'W':
        break
    if i == 7 and board[i][j] == 'B':
      result += 1

if result == 16:
  result = result / 2;

print result