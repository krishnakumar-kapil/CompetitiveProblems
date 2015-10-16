def main():
	s = raw_input()
	n, m = s.split(' ')
	q = [(n, 0)]
	seen = set(0)
	while q[0][0] != m:
		cur = q[0]
		q = [1:]
		if not cur[0] in seen:
			seen.add(cur[0])
			if cur[0] > 0
				q.append((cur[0] - 1), cur[1] + 1))
			if cur[0] < m
				q.append((2 * cur[0], cur[1] + 1))

	print(q[0][1])

	print("%r, %r" % (n , m))

if __name__ == "__main__":
  main()