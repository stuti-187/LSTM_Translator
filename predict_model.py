import numpy
import h5py
import xlrd
from sklearn.metrics.pairwise import cosine_similarity
from keras.models import load_model
from gensim.models.doc2vec import Doc2Vec,LabeledSentence
ip=[]
op=[]
array=[]
x=0
v=0
book=xlrd.open_workbook('/Users/stuti/Desktop/data.xlsx')
hindi=book.sheet_by_index(0)

model=load_model('model_file.h5')
output_model=Doc2Vec.load('outputvector.doc2vec')
for i in range(499):
    op.append(output_model[hindi.row_values(i)])

"""test=input("Enter Text")
print(test)
ip.append(test.split())
testmodel=LabeledSentence(words=['I','am','fine.'], tags=500)
model= Doc2Vec([testmodel], min_count = 1)"""
sentences=LabeledSentence(words=['The','heavy','rain','brought','the','flood','causing','a' ,'lot','of','damage','around.'], tags=['SENT_1']) 
model1 = Doc2Vec([sentences], size = 100, window = 1, min_count = 1, workers=1)
ip.append(model1['The','heavy','rain','brought','the','flood','causing','a' ,'lot','of','damage','around.'])
ip=numpy.asarray(ip).reshape(1,12,100)
ip=model.predict(ip).reshape(12,100)
op=numpy.asarray(op).reshape(5988,100)
print(ip.shape)
for i in range(10):
    x=0
    for j in range(12):
        #v=v+2*(j-1)
        #v=v+2*(1-abs(cosine_similarity(ip,op[i])[j]))
        x=x+abs(cosine_similarity(ip,op[i])[j])
        x=x/12
    #array[i]=2(1-x)
    array.append(x)
    
print(array)
m = max(array)
p = array.index(m)
print("['The','heavy','rain','brought','the','flood','causing','a' ,'lot','of','damage','around.']")
print(hindi.row_values(p))    
#print(abs(cosine_similarity(ip,op[8])[1])+abs(cosine_similarity(ip,op[8])[1]))
#print(cosine_similarity(ip,op[1]))
#print(hindi.row_values(8))
