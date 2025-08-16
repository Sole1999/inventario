
// RECUPERAR POSTS CON GET
export const getAllPostsService = () => {
  fetch('https://jsonplaceholder.typicode.com/posts')
    .then((response) => { return response.json() })
    .then((json) => { console.log(json) });
}

//CREAR O INSERTAR UN POST CON POST
/*
export const createPostService = () => {
  const config = {
    method: 'POST',
    body: JSON.stringify({
      title: 'mensaje',
      body: 'suerte en la evaluacion',
      userId: 1,
    }),
    headers: {
      'Content-type': 'application/json',
    }
  };

  fetch('https://jsonplaceholder.typicode.com/posts', config)
    .then((response) => { return response.json() })
    .then((json) => { console.log(json) });
}
*/

export const createPostService = (post, fnExito) => {
  const config = {
    method: 'POST',
    body: JSON.stringify({
      title: post.title,
      body: post.body,
      userId: 1,
    }),
    headers: {
      'Content-type': 'application/json',
    }
  };

  fetch('https://jsonplaceholder.typicode.com/posts', config)
    .then((response) => { return response.json() })
    .then((json) => { console.log(json), fnExito();});
}

//ACTUALIZAR O EDITAR POST CON PUT
export const updatePostService = () => {

  const config = {
    method: 'PUT',
    body: JSON.stringify({
      id: 1,
      title: 'mensaje final probando',
      body: 'probando con put para actualizar post',
      userId: 1
    }),
    headers: {
      'Content-type': 'application/json',
    }
  };

  fetch('https://jsonplaceholder.typicode.com/posts/1', config)
    .then((response) => { return response.json() })
    .then((json) => { console.log(json) });
}

//CONSULTAR O FILTRAR POR ID DE USUARIO
export const getByUserIdService = () => {
  fetch('https://jsonplaceholder.typicode.com/posts?userId=1')
    .then((response) => { return response.json() })
    .then((json) => { console.log(json) });
}

//PARTE 6:

//BOTON XXX PARA GET
export const btnXGetAllService = () => {
  fetch('https://api.chucknorris.io/jokes/random')
    .then((response) => { return response.json() })
    .then((json) => { console.log(json) });
}

//BOTON YYY PARA POST
export const btnYPostService = () => {

  const config={
    method:'POST',
    body: JSON.stringify({
      id: 0,
      title: 'Nuevo Producto',
      price: 123.00,
      description: 'para probar el Post con este boton Y',
      category: 'PRUEBA POST',
      image: 'http://imageninventada.com'
    }),
    headers: {
      "Content-type": "application/json"
    }
  };

  fetch('https://fakestoreapi.com/products', config)
    .then((response) => { return response.json() })
    .then((json) => { console.log(json) });
}

//BOTON ZZZ PARA PUT
export const btnZPutService=()=>{

  const config={
    method: 'PUT',
    body: JSON.stringify({
      id: 1,
      title: 'Actualizando Producto',
      price: 450.12,
      description: 'probando el Put con el boton ZZZ',
      category: "PRUEBA PUT",
      imagen: 'http://otraimagen.com',
    }),
    headers:{
      'Content-type': 'application/json'
    }
  };

  fetch('https://fakestoreapi.com/products/1', config)
  .then((response)=>{return response.json()})
  .then((data)=>{console.log(data)});
}

//INVOCAR DESDE MI IP DE LA COMPU

export const getDocumentTypes=()=>{
  fetch('http://192.168.100.169:8080/inventarios/rest/tipoDocumento/recuperar')
  .then((response)=>{return response.json()})
  .then((json)=>{console.log(json)});
}


/*

export const newDocumentTypes = (post, fnExito) => {
  console.log("INGRESANDO A LA FUNCION newDocumentTypes", post.title, " ", post.body)
  const config = {
    method: 'POST',
    body: JSON.stringify({
      codigo: post.title,
      descripcion: post.body,
    }),
    headers: {
      'Content-type': 'application/json'
    }
  };

  fetch('http://192.168.100.169:8080/inventarios/rest/tipoDocumento/agregar', config)
    .then((response) => {
      console.log("MENSAJE RESPONSE.JSON: ", response.json(), "Mensaje", response);
      if (!response.ok) {
        throw new Error("Error:" , response.status);
      } else{
        console.log("NOTIFICACION!!!");
      }
      return response.json()
    })
    .then((data) => { console.log("AQUI ESTA EL OBJETO EN CONSOLA: ", data), fnExito?.(data); })
    .catch((error) => {
      console.error("Error:", error);
    });
}
*/











export const newDocumentTypes=(post, fnExito)=>{
  console.log("INGRESANDO A LA FUNCION newDocumentTypes", post.title, " ", post.body)
  const config={
    method:'POST',
    body: JSON.stringify({
      codigo: post.title,
      descripcion: post.body,
    }),
    headers:{
      'Content-type': 'application/json'
    }
  };

  fetch('http://192.168.100.169:8080/inventarios/rest/tipoDocumento/agregar', config)
  //.then((response)=>{return response.json()})
  //.then((data) => { console.log(data), fnExito();});
}
