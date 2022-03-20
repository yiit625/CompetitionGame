import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";

@Injectable()
export class AppService {
  constructor(private http: HttpClient) {
  }

  onlineEditor(script: any) {
    return this.http.post<any>('http://localhost:8080/data/online-editor', script)
  }

  createPerson(name: any, selectedTaskId: any) {
    let params = new HttpParams().set('name', name).set('selectedTaskId', selectedTaskId)
    return this.http.post<any>('http://localhost:8080/data/create-person', params)
  }

  createPersonWithoutTaskId(name: any) {
    let params = new HttpParams().set('name', name)
    return this.http.post<any>('http://localhost:8080/data/create-person-without-taskid', params)
  }

  batchPeople() {
    return this.http.get<any>('http://localhost:8080/data/batch-people')
  }


}
