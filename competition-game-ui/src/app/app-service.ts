import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";

@Injectable()
export class AppService {
  constructor(private http: HttpClient) {
  }

  onlineEditor(scriptModel: ScriptModel) {
    return this.http.post<any>('http://localhost:8080/data/online-editor', scriptModel)
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

export class ScriptModel {
  script: string;
  outputParams: string[];
}
