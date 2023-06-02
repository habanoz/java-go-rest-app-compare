import http from 'k6/http'
import { check, sleep } from 'k6'


const port = __ENV.port;  

export default function () {
  const params = { headers: { 'Content-Type': 'application/json' } };
  // const port = 8081

  let res1 =http.post(`http://localhost:${port}/albums`, '{"id": "4","title": "The Modern Sound of Betty Carter","artist": "Betty Carter","price": 49.99}', params)
  check(res1, { 'success create': (r) => r.status === 201 })

  sleep(0.1)

  let res2 = http.get(`http://localhost:${port}/albums`)
  check(res2, { 'success list': (r) => r.status === 200 })

  sleep(0.1)
}
