import { View, StyleSheet, Alert } from 'react-native'
import { Button, Input, Text } from '@rneui/base'
import { useState } from 'react'
import { createPostService, newDocumentTypes } from '../services/TestServices'
export const PostForm = () => {
    const [subject, setSubject] = useState();
    const [message, setMessage] = useState();
    const [documento, setDocumento] = useState();
    const [alias, setAlias] = useState();

    const createPost = () => {
        console.log("creando post " + subject + " " + message);
        console.log("nuevo tipo de documento: " + alias + " " + documento);
        createPostService({
            title: subject,
            body: message
        },
            () => {
                Alert.alert("CONFIRMACION", "Se ha ingresado un nuevo POST");
            });
        console.log("EJECUTANDO documentTypes");    
        newDocumentTypes({
            title: alias,
            body: documento,
        }, () => {
            Alert.alert("NOTIFICACION", "Nuevo tipo de documento agregado");
        });
    }
    return <View style={styles.container}>
        <View style={styles.textContainer}>
            <Text h4="true">NUEVO MENSAJE</Text>
        </View>
        <View style={styles.formContainer}>
            <Input
                placeholder='TITULO'
                value={subject}
                onChangeText={(value) => {
                    setSubject(value);
                }}
            />
            <Input
                placeholder='MENSAJE'
                value={message}
                onChangeText={(value) => {
                    setMessage(value);
                }}
            />

            <Input
                placeholder='CODIGO DE TIPO DE DOCUMENTO'
                value={alias}
                onChangeText={(value) => {
                    setAlias(value);
                }}
            />
            <Input
                placeholder='TIPO DE DOCUMENTO'
                value={documento}
                onChangeText={(value) => {
                    setDocumento(value);
                }}
            />

            <Button
                title="Guardar"
                onPress={createPost}
            />
        </View>

    </View>
}
const styles = StyleSheet.create({
    container: {
        flex: 1,
        flexDirection: 'column',
        backgroundColor: '#fff',
        justifyContent: 'center',
    },
    textContainer: {
        flex: 1,
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center',
        marginVertical: 10
    },
    formContainer: {
        flex: 7,
        flexDirection: 'column',
        justifyContent: 'center'

    }
});
