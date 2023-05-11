import random


def name():
    alph = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
    not_vocals = ["b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","y","z"]
    vocals = ["a","e","i","o","u"]
    vocals_tsh = ["a","e","i","o","u","t","s","h","r"]
    vocals_g = ["a","e","i","o","u", "g"]
    string = random.choice(alph)
    lenght = random.randint(3,8)
    repeater = True
    while len(string) < lenght:

        if string[-1] in ["t", "s", "p","r", "k"]:
            if repeater: 
                new_letter = random.choice(vocals_tsh)
                if string[-1] == "r" and new_letter == "h":
                    continue
                elif string[-1] == "k" and new_letter == "p":
                    continue
                repeater = False
            else: 
                new_letter = random.choice(vocals)
                repeater = True 
        
        elif string[-1] == "n":
            new_letter = random. choice(vocals_g)

        elif string[-1] in vocals:
            if len(string) > 2 and (string[-2] in vocals and string[-3] in vocals):
                new_letter = random.choice(not_vocals)
            else:
                new_letter = random.choice(alph)
        
        elif string[-1] not in vocals:
            new_letter = random.choice(vocals)
            
        string += new_letter
    
    return string


