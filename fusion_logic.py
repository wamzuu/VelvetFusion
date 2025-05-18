import json

with open('personaData.json', 'r') as f:
    data = json.load(f)

with open('fusionChart.json', 'r') as f:
    chart = json.load(f)

arcanaOrder = [
  "Fool", "Magician", "Priestess", "Empress", "Emperor", 
  "Hierophant", "Lovers", "Chariot", "Justice", "Hermit", 
  "Fortune", "Strength", "Hanged Man", "Death", "Temperance", 
  "Devil", "Tower", "Star", "Moon", "Sun", "Judgement", "World"
]

persona1 = "Pixie"
persona2 = "Agathion"


def fuse(persona1, persona2):
    arcana1 = data[persona1]["arcana"]
    lvl1 = data[persona1]["lvl"]
    arcana2 = data[persona2]["arcana"]
    lvl2 = data[persona2]["lvl"]
    
    try:
        result = chart[arcana1][arcana2] if arcanaOrder.index(arcana1) < arcanaOrder.index(arcana2) else chart[arcana2][arcana1]
    except KeyError:
        return "Invalid fusion"
    
    print(result)   # result arcana

    resultLvl = (lvl1 + lvl2) // 2 + 1

    print(resultLvl) # result level

    bestMatch = None
    lowestLevel = float("inf")

    for name, persona in data.items():
        if persona["arcana"] == result and persona["lvl"] >= resultLvl:
            if persona["lvl"] < lowestLevel:
                bestMatch = name
                lowestLevel = persona["lvl"]
    
    if bestMatch:
        return bestMatch
    else:
        return "No valid fusion result"



if __name__ == "__main__":
    p1 = input("Enter first persona: ")
    p2 = input("Enter second persona: ")
    result = fuse(p1, p2)
    print("Fusion result:", result)
    



