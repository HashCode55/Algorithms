import math

def square_root(n):
	k = (int)(math.sqrt(n))
	for i in range(1, k+1):
		if i*i == n:
			return True

	return False		

def get_max_length(words):
	max = -1
	word = ""
	for i in words:
		if len(i) > max:
			max = len(i)
			word = i
	return (max, word)		

def break_number(num):
	return [(int)(i) for i in (str)(num)]		
#get the file 
words_file = open("words.txt", 'r').read()
list_words = [k[1:-1] for  k in words_file.split(",")]
#make a sorted word dictionary 
list_words_copy = {(''.join(sorted(k))):[] for i, k in enumerate(list_words)}

digits, word = get_max_length(list_words)
for word in list_words:
	list_words_copy[''.join(sorted(word))].append(word)
#make a cleaned the dictionary
final_dictionary = {}
for k in list_words_copy.keys():
	if len(list_words_copy[k])>=2:
		final_dictionary[k]=list_words_copy[k]
#this is the final dictionary which is of our use 
		
square_root_dict = {}

#initialise the dict 
for i in range(1, 11):
	square_root_dict[i] = []

for i in range(1, 10**5):
	square_root_dict[(int)(math.log10(i*i)+1)].append(i*i)



for word in final_dictionary.values():
	if len(word) != 2:
		continue
	bigo = word[0]
	sec_word = word[1]
	print bigo, sec_word
	num_dict = {}
	leng = len(bigo)
	for num in square_root_dict[leng]:
		#k is the current num
		k = break_number(num)
		#if the numbers are not unique 
		if len(set(k)) != leng:
			continue
		#allocate the numbers 	
		for cha, dig in zip(bigo, k):
			num_dict[cha] = dig	
		fin_num = ""	
		for cha in sec_word:
			fin_num = fin_num+(str)(num_dict[cha])
		fin_num = (int)(fin_num)

		if (int)(math.log10(fin_num)) + 1 != leng:
			continue
		if fin_num in square_root_dict[leng]:

			print fin_num, num	



