import { View, StyleSheet } from 'react-native'
import { Button, Text } from '@rneui/base'
import {getAllPostsService, createPostService, updatePostService, getByUserIdService, btnXGetAllService, btnYPostService, btnZPutService, getDocumentTypes} from '../services/TestServices'

export const TestWebServices = () => {

  const getAllPosts=()=>{
    getAllPostsService();
  }

  const createPost=()=>{
    createPostService();
  }
  
  const updatePost=()=>{
    updatePostService();
  }

  const getByUserId=()=>{
    getByUserIdService();
  }

  const btnXGetAll=()=>{
    btnXGetAllService();
  }

  const btnYPost=()=>{
    btnYPostService();
  }

  const btnZPut=()=>{
    btnZPutService();
  }

  const btnGetDocumentTypes=()=>{
    getDocumentTypes();
  }

  return <View style={styles.container}>
    <Text style={styles.textContainer}>MODULO 3</Text>
    <View style={styles.buttonContainer}>
      <Button
        title="Recuperar Posts"
        onPress={getAllPosts}
      />
      <Button
        title="Crear Post"
        onPress={createPost}
      />
        <Button
        title="Actualizar Post"
        onPress={updatePost}
      />
        <Button
        title="Filtrar"
        onPress={getByUserId}
      />
          <Button
        title="XXX"
        onPress={btnXGetAll}
      />

      <Button
        title="YYY"
        onPress={btnYPost}
      />

      <Button
        title="ZZZ"
        onPress={btnZPut}
      />

      <Button
      title="TIPOS DE DOCUMENTO"
      onPress={btnGetDocumentTypes}
      />
      
    </View>
  </View>
}
const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: 'column',
    backgroundColor: '#fff',
  },
  textContainer: {
    flex: 1,
    textAlign: 'center',
    fontSize: 18,
    marginVertical: 10
  },
  buttonContainer: {
    flex: 6,
    alignItems: 'stretch',
    justifyContent: 'space-around',
    marginHorizontal:10

  }
});