from gensim.models.doc2vec import Doc2Vec,Word2Vec
import xlrd
from keras.preprocessing import sequence
from keras.layers import Embedding,LSTM,Dense,Dropout,Reshape
from keras.models import Sequential, load_model
import numpy
import h5py
from sklearn.metrics.pairwise import cosine_similarity
book=xlrd.open_workbook('/Users/stuti/Desktop/data.xlsx')
i=1
hindi=book.sheet_by_index(0)
eng=book.sheet_by_index(1)
ip=[]
op=[]
pip=[]
predict=[]
predicted_output=[]
#train_input=Doc2Vec.load('output_vector.doc2vec')
#for i in range(130):
#    op.append(train_input.wv.index2word[i])
#print(op)

input_model=Doc2Vec.load('inputvector.doc2vec')
output_model=Doc2Vec.load('outputvector.doc2vec')

print('model loaded')
#['I','am','going','to','go','play','ball','with','Mohan.']
#['मैं','मोहन','के','साथ'	,'गेंद'	,'खेलने','जा','रहा','हूँ।']
for i in range(5):
    ip.append(input_model[eng.row_values(i)])

for i in range(5):
    op.append(output_model[hindi.row_values(i)])


ip=numpy.asarray(ip).reshape(5,12,100)
op=numpy.asarray(op).reshape(5,12,100)
print(ip.shape[1])
print(ip.shape[2])
model3 = Sequential()
#model3.add(Dense(100,activation='relu',input_dim=100))
#model3.add(Embedding(101,100,input_length=9))
model3.add(LSTM(output_dim=100,input_shape=(12,100),return_sequences=True,activation='sigmoid'))
#model3.add(Reshape((24,100), input_shape=(11,200)))
model3.add(Dropout(0.2))
model3.add(Dense(100,activation='softmax'))
model3.compile(loss='cosine_proximity',optimizer='adam', metrics=['accuracy'])
print(model3.input_shape)
print(model3.output_shape)
model3.fit(ip,op,batch_size=5,nb_epoch=150,verbose=1)
score=model3.evaluate(ip,op,batch_size=1)
model3.save('model_file.h5')
#pip=model3.predict(text).reshape(360,100)
#ip=ip.reshape(360,100)
#for i in range(30):
#    print(cosine_similarity(pip,ip[i]))

    
        
