const base = process.env.REACT_APP_ENDPOINT;
export default {
    async get(path){
        return await fetch(base + path).then(j=>j.json());
    },
    async post(path, body){
        return await this.complex_post(path, body, "POST");
    },
    async delete(path){
        return await this.complex_delete(path, "DELETE");
    },
    async complex_post(path, body, method='POST'){
        return await fetch(base + path,{
            method: method,
            mode: 'cors',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(body)
        }).then(j=>j.json());
    },
    async complex_delete(path, method='DELETE'){
        return await fetch(base + path,{
            method: method,
            mode: 'cors'
        }).then(j=>j.json());
    }
}