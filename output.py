import xlrd
from gensim.models.doc2vec import Doc2Vec,LabeledSentence

book=xlrd.open_workbook('/Users/stuti/Desktop/data.xlsx')
i=1
sheet=book.sheet_by_index(0)
sentences=[]
row=sheet.row_values(1)
print (row)


for i in range(499):
    sentences.append(LabeledSentence(words=sheet.row_values(i), tags=[i]))

model= Doc2Vec(sentences,min_count = 1)
model.save('outputvector.doc2vec')
model_loaded = Doc2Vec.load('outputvector.doc2vec')
print('model loaded')
print(model_loaded['मैं'    ,'मोहन',	'के',	'साथ',	'गेंद',	'खेलने',	'जा',	'रहा',	'हूँ।']) 





