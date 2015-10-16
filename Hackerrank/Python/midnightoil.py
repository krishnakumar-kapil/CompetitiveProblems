def main():
	val = input()
	valS = val.split(' ')
	n = int(valS[0])
	k = int(valS[1])

	lower = 0
	high = n
	while lower <= high:
		printf("mid")
		mid = lower + (high - lower)/2
		if check(n, mid, k):
			high = mid - 1
		else:
			lower = mid + 1

	print(lower)

def check(n , v , k):
	denom = 1;
	sum = 0
	while (v / denom) != 0:
		print(v / denom)
		denom *= k
		sum += int(v / denom)
	return sum >= n


if __name__ == '__main__':
	main()