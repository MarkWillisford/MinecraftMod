import json
# Inputs
# shapes: block, stairs, slab, step, button, fence,
# pressurePlate, verticalSlab, sapling,
# isTree, isStone
shape = 'block'
modid = 'jpsbase'
name = 'example_block'
fileName = name

# Loot_table



# Blockstate
if shape == 'block':
    blockstate = {
        "variants": {
            "":{ "model": modid + ":block/" + name }
	}
    }

# Model.block
if shape == 'block':
    modelBlock = {
        "parent": "block/cube_all",
        "textures": {
            "all": modid + ":blocks/" + name
        }
    }

# Model.item
if shape == 'block':
    modelItem = {
        "parent": modid + ":block/" + name
    }

# The writing method
def writeToJSONFile(path, fileName, data):
    filePathNameWExt = './' + path + '/' + fileName + '.json'
    with open(filePathNameWExt, 'w') as fp:
        json.dump(data, fp, indent=2, sort_keys=True, )

path = 'assets/jpsbase/blockstates'
data = blockstate
writeToJSONFile(path,fileName,data)
print(json.dumps(data, indent=2, sort_keys=True))

path = 'assets/jpsbase/models/block'
data = modelBlock
writeToJSONFile(path,fileName,data)
print(json.dumps(data, indent=2, sort_keys=True))

path = 'assets/jpsbase/models/item'
data = modelItem
writeToJSONFile(path,fileName,data)
print(json.dumps(data, indent=2, sort_keys=True))
